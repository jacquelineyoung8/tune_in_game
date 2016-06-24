const React = require('react');
const ReactDOM = require('react-dom');
const _ = require('lodash');

class GreeterBox extends React.Component {
  constructor(props){
    super(props);
    this.state = {value: this.props.value};
    this.handleChange = this.handleChange.bind(this);
  }
  handleChange(event) {
    this.setState({value: event.target.value});
  }
  render() {
    return (
      <div>
        <label> Name: </label>
        <input type="text" value={this.state.value} onChange={this.handleChange} />

        <div className="greeterBox">
            Hello, I am a {_.join(_.reverse(_.split(this.state.value, "")), "")}
        </div>
      </div>
    );
  }
}

class GreeterDad extends React.Component {
	render() {
		return(
			<div className="greeterBox">
				<p className="header">
					<GreeterBox
						value="Jackie" />
					<GreeterBox
						value="Scott"/>
				</p>
			</div>);
	}
}
	

ReactDOM.render(
  <GreeterDad />,
  document.getElementById('example')

);
