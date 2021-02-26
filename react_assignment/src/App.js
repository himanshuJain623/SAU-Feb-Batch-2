import Books from "./components/Books";
import Header from "./components/Header";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import SingleBook from "./components/SingleBook";

function App() {
  return (
    <Router>
      <main>
        <Header />
        <Switch>
          <Route exact path="/">
            <Books />
          </Route>
          <Route path="/book/:id">
            <SingleBook />
          </Route>
        </Switch>
      </main>
    </Router>
  );
}

export default App;
