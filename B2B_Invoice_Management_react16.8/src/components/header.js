import React from 'react';
import ABCLogo from './abclogo.svg';
import H2HLogo from './hrclogo.svg';

function HeaderComponent() {
    return (
    <div>
      <div style={{ display: 'flex', justifyContent: 'space-between'}}>
        <img src={ABCLogo} alt="ABC Logo" />
        <img src={H2HLogo} alt="H2H Logo" />
        <img src={ABCLogo} alt="ABC Logo" style={{ visibility: 'hidden' }} />
      </div>
      <h1 style={{  color: '#db4437', textAlign: 'left' }}>Invoice List</h1>
    </div>
    );
}

export default HeaderComponent;