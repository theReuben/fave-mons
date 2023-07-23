import React, { Component } from "react";
import "./App.css";
import FaveMonList from "./FaveMonList.js"

class App extends Component {

  state = {
    faveMons: []
  };

  async componentDidMount() {
    const response = await fetch('/fave-mons/all');
    const body = await response.json();
    this.setState({faveMons: body});
  }

  render() {
    const {faveMons} = this.state;
    return (
        <div className="App">
          <header className="App-header">
            <div className="App-intro">
            <h2>Fave Mons</h2>
              <FaveMonList faveMons={faveMons} />
            </div>
          </header>
        </div>
    );
  }
}
export default App;
