import React, { useState } from 'react';
import { TextField, Button, Grid } from '@material-ui/core';
import axios from 'axios';

function AddDataForm() {
  const [formData, setFormData] = useState({
    customerOrderId: '',
    salesOrg: '',
    distributionChannel: '',
    customerNumber: '',
    companyCode: '',
    orderCurrency: '',
    amountInUSD: '',
    orderCreationDate: '',
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    // Convert form data to query parameters
    const queryParams = new URLSearchParams(formData).toString();

    // Send the request with query parameters
    axios.post(`http://localhost:8081/h2h_milestone_1/AddServlet?${queryParams}`)
      .then((response) => {
        // Handle the response
        console.log('Response:', response.data);
      })
      .catch((error) => {
        // Handle the error
        console.error('Error:', error);
      });

    // Reset the form after submitting
    setFormData({
      customerOrderId: '',
      salesOrg: '',
      distributionChannel: '',
      customerNumber: '',
      companyCode: '',
      orderCurrency: '',
      amountInUSD: '',
      orderCreationDate: '',
    });
  };

  const handleClear = () => {
    setFormData({
      customerOrderId: '',
      salesOrg: '',
      distributionChannel: '',
      customerNumber: '',
      companyCode: '',
      orderCurrency: '',
      amountInUSD: '',
      orderCreationDate: '',
    });
  };

  return (
    <form onSubmit={handleSubmit} style={{ margin: '5px 0px' }}>
      <Grid container spacing={2}>
        <Grid item xs={3}>
          <TextField
            name="customerOrderId"
            label="Customer Order ID"
            variant='outlined'
            value={formData.customerOrderId}
            onChange={handleInputChange}
            fullWidth
          />
        </Grid>
        <Grid item xs={3}>
          <TextField
            name="salesOrg"
            label="Sales Org"
            variant='outlined'
            value={formData.salesOrg}
            onChange={handleInputChange}
            fullWidth
          />
        </Grid>
        <Grid item xs={6}>
          <TextField
            name="distributionChannel"
            label="Distribution Channel"
            variant='outlined'
            value={formData.distributionChannel}
            onChange={handleInputChange}
            fullWidth
          />
        </Grid>
        <Grid item xs={3}>
          <TextField
            name="customerNumber"
            label="Customer Number"
            variant='outlined'
            value={formData.customerNumber}
            onChange={handleInputChange}
            fullWidth
          />
        </Grid>
        <Grid item xs={3}>
          <TextField
            name="companyCode"
            label="Company Code"
            variant='outlined'
            value={formData.companyCode}
            onChange={handleInputChange}
            fullWidth
          />
        </Grid>
        <Grid item xs={2}>
          <TextField
            name="orderCurrency"
            label="Order Currency"
            variant='outlined'
            value={formData.orderCurrency}
            onChange={handleInputChange}
            fullWidth
          />
        </Grid>
        <Grid item xs={2}>
          <TextField
            name="amountInUSD"
            label="Amount in USD"
            variant='outlined'
            value={formData.amountInUSD}
            onChange={handleInputChange}
            fullWidth
          />
        </Grid>
        <Grid item xs={2}>
          <TextField
            name="orderCreationDate"
            label="Order Creation Date"
            variant='outlined'
            type="date"
            value={formData.orderCreationDate}
            onChange={handleInputChange}
            InputLabelProps={{
              shrink: true,
            }}
            fullWidth
          />
        </Grid>
      </Grid>
    
      <Grid container spacing={2}>
        <Grid item xs={6}>
          <Button type="submit"
           variant="contained" 
           style={{ backgroundColor: '#fc7500', color: '#ffffff' }} 
           fullWidth
          >
            Add
          </Button>
        </Grid>
        <Grid item xs={6}>
          <Button 
            variant="contained" 
            style={{ backgroundColor: '#db4437', color: '#ffffff' }}
            onClick={handleClear} 
            fullWidth
          >
            Clear Data
          </Button>
        </Grid>
      </Grid>
    </form>
  );
}

export default AddDataForm;
