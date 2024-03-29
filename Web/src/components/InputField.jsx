import React, { useState } from 'react';
import { Form, Row, Col } from 'react-bootstrap';
import '../assets/css/components/InputField.css';

const InputField = ({ type, label, idcontrol, ph, maxLength }) => {
  const [value, setValue] = useState('');

  const handleChange = (event) => {
    const inputValue = event.target.value;
    if (inputValue.length <= maxLength) {
      setValue(inputValue);
    }
  };

  return (
    <Form.Group as={Row} className="mb-3" controlId={idcontrol}>
      <Form.Label column sm={2} className="inputField_input-label">
        {label}
      </Form.Label>
      <Col sm={10}>
        <Form.Control
          type={type}
          className="inputField_input"
          placeholder={ph}
          value={value}
          onChange={handleChange}
        />
      </Col>
    </Form.Group>
  );
};

export default InputField;