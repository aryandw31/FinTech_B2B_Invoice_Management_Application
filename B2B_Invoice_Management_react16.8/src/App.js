import React from 'react';
import HeaderComponent from './components/header';
import TabsComponent from './components/TabsComponent';
import FooterComponent from './components/footer';
// import DataGridComponent from './components/datagrid';

function App() {
  return (
    <div>
      <HeaderComponent />
      <TabsComponent />
      {/* <DataGridComponent /> */}
      <FooterComponent />
    </div>
  );
}

export default App;
