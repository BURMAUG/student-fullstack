const API= 'http://localhost:8080/api/v1/';

export const homer = () =>
    fetch(API, {
        method: 'GET',
        mode: 'cors',
        headers: {'Content-Type' : 'application/json'}
    });
export const postASimForm = student =>
    fetch(API, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(student)
    });
export const lisaDelete = id =>
    fetch(API+`${id}`, {
       method: 'DELETE',
    });
export const bartaEdit = (student, id) =>
    fetch(API+`${id}`,{
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(student)
    });