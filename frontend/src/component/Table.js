import {useEffect, useState} from "react";
import {homer, lisaDelete} from "../client";
import {toast, ToastContainer} from "react-toastify";
import {Link} from "react-router-dom";
import {useStudentContext} from "./StudentContext";

const Table = () =>{
    const [students, setStudents] = useState([]);
    const { storeSelectedStudent } = useStudentContext();

    function fetchData(){
        homer()
            .then(res => res.json())
            .then(resData => setStudents(resData))
            .catch(err => console.error(err))
    }

    useEffect(() => {
        fetchData();
    }, []);

    if (students.length <= 0){
        return "No data";
    }

    function handleDelete(id) {
        lisaDelete(id)
            .then(() => {
                toast.success("Student Deleted", {
                    position: toast.POSITION.TOP_RIGHT,
                    theme: "dark"
                });
                fetchData();
            })
            .catch(err => console.error(err));
    }


    return (
        <div>
            <table className="table">
                <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Major</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                {
                    students.map((student, idx) =>{
                        return(
                            <tbody key={idx}>
                            <tr>
                                <td>
                                    <Link
                                        to= '/update'
                                        onClick = {()=> storeSelectedStudent(student)}
                                        className="student"
                                    >
                                    {student.name}
                                    </Link>
                                </td>
                                <td>{student.email}</td>
                                <td>{student.major}</td>
                                <td><button type="button" className="btn btn-danger btn-sm" onClick={() => handleDelete(student.student_id)}>Delete</button></td>
                                <ToastContainer autoClose={1500} />
                            </tr>
                            </tbody>
                        );
                    })
                }
            </table>
        </div>
    );
}
export default Table;