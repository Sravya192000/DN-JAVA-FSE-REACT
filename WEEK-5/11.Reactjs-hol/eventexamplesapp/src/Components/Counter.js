import React, { Component } from "react";

class Counter extends Component {

  constructor(props) {
    super(props);

    this.state = {
      count: 0
    };

    this.increment = this.increment.bind(this);
    this.decrement = this.decrement.bind(this);
    this.sayHello = this.sayHello.bind(this);
    this.handleIncrease = this.handleIncrease.bind(this);
  }

  // Method to increment counter
  increment() {
    this.setState({
      count: this.state.count + 1
    });
  }

  // Method to decrement counter
  decrement() {
    this.setState({
      count: this.state.count - 1
    });
  }

  // Method to display hello message
  sayHello() {
    alert("Hello! This is a static message.");
  }

  // Method that calls multiple methods
  handleIncrease() {
    this.increment();
    this.sayHello();
  }

  render() {
    return (
      <div>
        <h2>Counter Application</h2>

        <h3>Counter Value: {this.state.count}</h3>

        <button onClick={this.handleIncrease}>
          Increase
        </button>

        &nbsp;&nbsp;

        <button onClick={this.decrement}>
          Decrease
        </button>
      </div>
    );
  }
}

export default Counter;