import React, { useEffect, useState } from 'react';
import { DataGrid } from '@mui/x-data-grid';
import axios from 'axios';
import { Button, Dialog, DialogTitle, DialogContent, DialogActions, TextField, Grid } from '@material-ui/core';

const columns = [
  { field: 'Sl_no', headerName: 'Sl No', width: 120 },
  { field: 'CUSTOMER_ORDER_ID', headerName: 'Customer Order Id', width: 200 },
  { field: 'SALES_ORG', headerName: 'Sales Org', width: 140 },
  { field: 'DISTRIBUTION_CHANNEL', headerName: 'Distribution Channel', width: 210 },
  { field: 'COMPANY_CODE', headerName: 'Company Code', width: 180 },
  { field: 'ORDER_CREATION_DATE', headerName: 'Order Creation Date', width: 210 },
  { field: 'ORDER_CURRENCY', headerName: 'Order Currency', width: 180 },
  { field: 'CUSTOMER_NUMBER', headerName: 'Customer Number', width: 200 },
  { field: 'AMOUNT_IN_USD', headerName: 'Amount in USD', width: 180 },
  { field: 'ORDER_AMOUNT', headerName: 'Order Amount', width: 170 },
];

function DataGridComponent({ fullData, fetchedData, value }) {
  const [data, setData] = useState(fetchedData);
  const [selectedRows, setSelectedRows] = useState([]);
  const [confirmationDialogOpen, setConfirmationDialogOpen] = useState(false);
  const [editDialogOpen, setEditDialogOpen] = useState(false);
  const [selectedRowForEdit, setSelectedRowForEdit] = useState(null);

  useEffect(() => {
    if(value === 0)
      setData(fullData)
    else
      setData(fetchedData);
  }, [fullData, fetchedData, value]);

  const handleDelete = () => {
    if (selectedRows.length > 0) {
      setConfirmationDialogOpen(true);
    }
  };

  const handleConfirmDelete = () => {
    // Filter out the selected rows from the data
    const newData = data.filter((row) => !selectedRows.includes(row.id));

    // Update the data and selected state
    setData(newData);
    console.log('Selected Rows:', selectedRows);
    
    // Make a DELETE request to the backend for each selected row
    selectedRows.forEach((Sl_no) => {
      axios
        .post(`http://localhost:8081/B2B_Invoice_Management_Java/DeleteServlet?DEL_ID=${Sl_no}`)
        .then((response) => {
          console.log('Delete success:', response.data);
        })
        .catch((error) => {
          console.error('Delete error:', error);
        });
    });
    setSelectedRows([]);

    setConfirmationDialogOpen(false);
  };

  const handleCancelDelete = () => {
    setConfirmationDialogOpen(false);
  };

  const handleEdit = () => {
    if (selectedRows.length === 1) {
      const selectedRow = data.find((row) => row.id === selectedRows[0]);
      setSelectedRowForEdit(selectedRow);
      setEditDialogOpen(true);
    }
  };

  const handleCancelEdit = () => {
    setEditDialogOpen(false);
    setSelectedRowForEdit(null);
  };

  const handleSaveEdit = () => {
    // Update the edited row with the new values
    const updatedData = data.map((row) => {
      if (row.id === selectedRowForEdit.id) {
        axios
        .post(
          `http://localhost:8081/B2B_Invoice_Management_Java/EditServlet?UPD_ID=${row.Sl_no}&UPD_COMPANY_CODE=${selectedRowForEdit.COMPANY_CODE}&UPD_DISTRIBUTION_CHANNEL=${selectedRowForEdit.DISTRIBUTION_CHANNEL}&UPD_ORDER_CURRENCY=${selectedRowForEdit.ORDER_CURRENCY}`
        )
        .then((response) => {
          console.log('Edit success:', response.data);
        })
        .catch((error) => {
          console.error('Edit error:', error);
        });
        return {
          ...row,
          ORDER_CURRENCY: selectedRowForEdit.ORDER_CURRENCY,
          COMPANY_CODE: selectedRowForEdit.COMPANY_CODE,
          DISTRIBUTION_CHANNEL: selectedRowForEdit.DISTRIBUTION_CHANNEL,
        };
      }
      return row;
    });
    
    setData(updatedData);
    setEditDialogOpen(false);
    setSelectedRowForEdit(null);
  };

  const handleEditRowValueChange = (field, value) => {
    setSelectedRowForEdit((prevSelectedRow) => ({
      ...prevSelectedRow,
      [field]: value,
    }));
  };

  const handleSelectionModelChange = (selectionModel) => {
    setSelectedRows(selectionModel.filter((rowId) => data.some((row) => row.id === rowId)));
  };

  return (
    <div>
      <div style={{ height: 400, width: '100%' }}>
        <DataGrid
          style={{ backgroundColor: '#5e5e60', color: '#ffffff', border: '0' }}
          columns={columns}
          rows={data}
          checkboxSelection
          rowsPerPageOptions={[100, 50, 25, 15, 8]}
          onSelectionModelChange={handleSelectionModelChange}
          isRowSelectable={(params) => data.some((row) => row.id === params.id)}
          disableSelectionOnClick
        />
      </div>

      <div>


        <Button
          variant="contained"
          color="primary"
          onClick={handleDelete}
          disabled={selectedRows.length === 0}
          style={{ margin: '5px', backgroundColor: '#fc7500' }}
        >
          DELETE
        </Button>


        <Button
          variant="contained"
          color="primary"
          onClick={handleEdit}
          disabled={selectedRows.length !== 1}
          style={{ margin: '5px', backgroundColor: '#fc7500' }}
        >
          EDIT
        </Button>

      </div>

      <Dialog open={confirmationDialogOpen}>
        <DialogTitle>Confirm Deletion</DialogTitle>
        <DialogContent>
          Are you sure you want to delete these record[s]?
        </DialogContent>
        <DialogActions>
          <Button onClick={handleCancelDelete} color="primary" variant='outline'>
            Cancel
          </Button>
          <Button onClick={handleConfirmDelete} color="primary" variant='outline'>
            Confirm
          </Button>
        </DialogActions>
      </Dialog>

      <Dialog open={editDialogOpen}>
        <DialogTitle>Edit Row</DialogTitle>
        <DialogContent>
        <Grid container spacing={2}>
          <Grid item xs={6}>
            <TextField
              label="Order Currency"
              variant='outlined'
              value={selectedRowForEdit ? selectedRowForEdit.ORDER_CURRENCY : ''}
              onChange={(e) => handleEditRowValueChange('ORDER_CURRENCY', e.target.value)}
            />
          </Grid>
          <Grid item xs={6}>
            <TextField
              label="Company Code"
              variant='outlined'
              value={selectedRowForEdit ? selectedRowForEdit.COMPANY_CODE : ''}
              onChange={(e) => handleEditRowValueChange('COMPANY_CODE', e.target.value)}
            />
          </Grid>
          <Grid item xs={12}>
            <TextField
              label="Distribution Channel"
              variant='outlined'
              value={selectedRowForEdit ? selectedRowForEdit.DISTRIBUTION_CHANNEL : ''}
              onChange={(e) => handleEditRowValueChange('DISTRIBUTION_CHANNEL', e.target.value)}
            />
          </Grid>
        </Grid>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleCancelEdit} color="primary" variant='contained'>
            Cancel
          </Button>
          <Button onClick={handleSaveEdit} color="primary" variant='contained'>
            Save
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}

export default DataGridComponent;
