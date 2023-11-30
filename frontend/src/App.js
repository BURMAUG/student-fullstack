import './App.css';
import Table from "./component/Table";
import Navbar from "./component/Navbar";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Form from "./component/Form";
import Update from "./component/Update";
import {StudentProvider} from "./component/StudentContext";

function App() {
  return (
    <div className="App">
        <BrowserRouter>
            <StudentProvider>
            <Routes>
                <Route path="/" element= {<Navbar />}>
                    <Route index Component={Table} />
                    <Route path="form" Component={Form} />
                    <Route path="/update" Component={Update} />
                </Route>
            </Routes>
            </StudentProvider>
        </BrowserRouter>
    </div>
  );
}

export default App;
