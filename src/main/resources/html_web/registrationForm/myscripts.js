function showCourses() {
    const dataTable = document.getElementById("coursetable");
    if (!dataTable) {
        console.error('Element with id "coursetable" not found.');
        return;
    }

    // Clear any existing rows
    dataTable.innerHTML = '';

    fetch("http://localhost:8080/courses")
        .then((response) => {
            if (!response.ok) {
                throw new Error(`Network response was not ok: ${response.status} ${response.statusText}`);
            }
            return response.json();
        })
        .then((courses) => {
            // Support APIs that return either an array or an object like { courses: [...] }
            const list = Array.isArray(courses) ? courses : (courses && courses.courses) || [];

            if (list.length === 0) {
                dataTable.innerHTML = '<tr><td colspan="4" align="center">No courses available</td></tr>';
                return;
            }

            const rows = list.map(course => {
                const id = course.courseId ?? course.id ?? '';
                const name = course.courseName ?? course.name ?? '';
                const trainer = course.trainer ?? '';
                const duration = course.durationInWeeks ?? course.duration ?? '';
                return `<tr>
                    <td>${id}</td>
                    <td>${name}</td>
                    <td>${trainer}</td>
                    <td>${duration}</td>
                </tr>`;
            }).join('');

            dataTable.innerHTML = rows;
        })
        .catch((err) => {
            console.error('Failed to load courses:', err);
            dataTable.innerHTML = '<tr><td colspan="4" align="center">Error loading courses</td></tr>';
        });
}

function showEnrolled() {

    const dataTable = document.getElementById("enrolltable");
    if (!dataTable) {
        console.error('Element with id "enrolltable" not found.');
        return;
    }

    // Clear any existing rows
    dataTable.innerHTML = '';

    fetch("http://localhost:8080/courses/enrolled")
        .then((response) => {
            if (!response.ok) {
                throw new Error(`Network response was not ok: ${response.status} ${response.statusText}`);
            }
            return response.json();
        })
        .then((students) => {
            // Support APIs that return either an array or an object like { courses: [...] }
            const list = Array.isArray(students) ? students : (students && students.students) || [];

            if (list.length === 0) {
                dataTable.innerHTML = '<tr><td colspan="4" align="center">No students available</td></tr>';
                return;
            }

            const rows = list.map(student => {
                const name = student.name ?? course.name ?? '';
                const emailId = student.emailId ?? student.emailId ?? '';
                const courseName = student.courseName ?? '';
            
                return `<tr>
                    <td>${name}</td>
                    <td>${emailId}</td>
                    <td>${courseName}</td>
                </tr>`;
            }).join('');

            dataTable.innerHTML = rows;
        })
        .catch((err) => {
            console.error('Failed to load courses:', err);
            dataTable.innerHTML = '<tr><td colspan="4" align="center">Error loading courses</td></tr>';
        });
}