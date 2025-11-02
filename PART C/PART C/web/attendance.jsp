<!DOCTYPE html>
<html>
<head>
  <title>Student Attendance Portal</title>
</head>
<body>
  <h2>Mark Attendance</h2>
  <form action="AttendanceServlet" method="post">
    <label>Student ID:</label>
    <input type="text" name="studentId" required><br><br>

    <label>Date:</label>
    <input type="date" name="date" required><br><br>

    <label>Status:</label>
    <select name="status">
      <option value="Present">Present</option>
      <option value="Absent">Absent</option>
    </select><br><br>

    <input type="submit" value="Submit Attendance">
  </form>
</body>
</html>
