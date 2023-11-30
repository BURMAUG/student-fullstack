import React, { useEffect, useState } from "react";
import { bartaEdit} from "../client";
import { useStudentContext } from "./StudentContext";
import {toast, ToastContainer} from "react-toastify";

const Update = () => {
    const { selectedStudent } = useStudentContext();

    const [student, setStudent] = useState({
        name: '',
        email: '',
        major: ''
    });

    useEffect(() => {
        if (selectedStudent) {
            setStudent({
                name: selectedStudent.name || '',
                email: selectedStudent.email || '',
                major: selectedStudent.major || ''
            });
        }
    }, [selectedStudent]);

    const handleSubmit = (event) => {
        event.preventDefault();
        bartaEdit(student, selectedStudent.student_id)
            .then(res => {
                if (res.ok){
                    toast.success('Update Successful', {
                        position: 'top-right',
                        theme: 'dark',
                        autoClose: 1200
                    });
                    setStudent({name: '', email: '', major: ''});
                }else {
                    toast.error('Unable To Update',{
                        position: 'top-right',
                        theme: 'dark',
                        autoClose: 1000
                    })
                }
            })
            .catch(err=>{console.error(err)});
    };

    const handleChange = (event) => {
        setStudent({ ...student, [event.target.name]: event.target.value });
    };

    return (

        <form onSubmit={handleSubmit}>
            <br/>
            <input
                type="text"
                placeholder="Name"
                value={student.name}
                className="form-control"
                id="exampleInput1"
                name="name"
                onChange={handleChange}
                autoComplete="on"
            /><br/>
            <input
                type="email"
                placeholder="Email"
                value={student.email}
                className="form-control"
                id="exampleInputEmail1"
                name="email"
                onChange={handleChange}
                autoComplete="on"
            /><br/>
            <input
                type="text"
                placeholder="Major"
                value={student.major}
                className="form-control"
                id="exampleInput2"
                name="major"
                onChange={handleChange}
                autoComplete="on"
            /><br/>
            <button type="button" className="btn btn-warning btn-sm" onClick={handleSubmit}>Update</button>
            <ToastContainer />
        </form>
    );
};

export default Update;
