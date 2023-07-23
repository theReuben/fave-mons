import React, { useMemo, useState } from 'react';
import { AgGridReact } from 'ag-grid-react';

import 'ag-grid-community/styles/ag-grid.css';
import 'ag-grid-community/styles/ag-theme-alpine.css';

function FaveMonList(props) {
    const [columnDefs] = useState([
        { field: 'person' },
        { field: 'type' },
        { field: 'monName' },
        { field: 'gen'},
        { field: 'primaryType'},
        { field: 'secondaryType'}
    ]);
    const containerStyle = useMemo(() => ({ width: '100%', height: '100%' }), []);
    const gridStyle = useMemo(() => ({ height: '100%', width: '100%' }), []);

    return (
              <div className="ag-theme-alpine" style={{height: 600, width: 1200}}>
                          <AgGridReact
                              rowData={props.faveMons}
                              columnDefs={columnDefs}>
                          </AgGridReact>
                      </div>
  );

}

export default FaveMonList;