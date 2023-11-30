import {useState} from "react";
import {postASimForm} from "../client";
import {ToastContainer, toast} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
const Form = () =>{
    const [student, setStudent] = useState(
        {
            name : '',
            email: '',
            major: ''
        });

    function handleChange(event) {
        setStudent({...student, [event.target.name]: event.target.value});
    }

    function handleSave() {
        postASimForm(student)
            .then(res =>{
                if (res.ok){
                    console.log("whats going on today with this???????")
                    toast.success('Student add', {
                        position: 'top-right',
                        theme: 'dark',
                        autoClose: 2000
                    });
                    setStudent({name: '', email: '', major: ''});
                }else{
                    toast.error(
                        'Unable To Add Student',{
                            position: 'top-right',
                            theme: 'dark',
                            autoClose: 1000
                        }
                    )
                }
            })
            .catch(err => console.error(err));
    }
    return (
        <div className="p-lg-5">
        <form className="p-lg-5 ms-5">
            <div className="mb-3">
                <input autoComplete="on" type="text" name="name" className="form-control" id="exampleInput1" placeholder="Name" value={student.name} onChange={handleChange}/>
            </div>

            <div className="mb-3">
                <input autoComplete="on" type="email" name="email" className="form-control" id="exampleInputEmail1" placeholder="Email" value={student.email} onChange={handleChange}/>
            </div>

            <div className="mb-3">
                <input autoComplete="on" value={student.major} type="text" name="major" className="form-control" id="exampleInput2" placeholder="Major" onChange={handleChange}/>
            </div>
            <button type="button" className="btn btn-success btn-sm" onClick={handleSave}>Submit</button>
        </form>
            <ToastContainer />
        </div>
    )
}
export default Form;