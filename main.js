const React = require('react');
const ReactDOM = require('react-dom');
const _ = require('lodash');

class Note extends React.Component {
  constructor(props, name){
    super(props);
    this.name = name;
    this.soundFile = new Audio(`Note Sounds/${this.name}.wav`);

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

        <div className="NoteBox">
            Hello, I am a {_.join(_.reverse(_.split(this.state.value, "")), "")}
        </div>
      </div>
    );
  }
}

class NoteDad extends React.Component {
	render() {
		return(
			<div className="NoteBox">
				<p className="header">
					<NoteBox
						value="Jackie" />
					<NoteBox
						value="Scott"/>
				</p>
			</div>);
	}
}
	

ReactDOM.render(
  <NoteDad />,
  document.getElementById('example')

);
