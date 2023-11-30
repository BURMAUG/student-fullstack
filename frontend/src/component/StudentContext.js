// StudentContext.js
import React, { createContext, useContext, useState } from 'react';

const StudentContext = createContext();

export const useStudentContext = () => useContext(StudentContext);

export const StudentProvider = ({ children }) => {
    const [selectedStudent, setSelectedStudent] = useState(null);

    const storeSelectedStudent = (student) => {
        setSelectedStudent(student);
    };

    return (
        <StudentContext.Provider value={{ selectedStudent, storeSelectedStudent }}>
            {children}
        </StudentContext.Provider>
    );
};
