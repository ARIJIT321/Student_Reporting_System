<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Add Student</title>
  </head>
  <body>
    <h1>Add Student</h1>
    <form method="post" action="${pageContext.request.contextPath}/addStudent">
      <label for="name">Name:</label>
      <input type="text" name="name" required><br><br>
      <label for="semester">Semester:</label>
      <select name="semester" required>
        <option value="1">1st Semester</option>
        <option value="2">2nd Semester</option>
      </select><br><br>
      <label for="english">English:</label>
      <input type="number" name="english" required min="0" max="100"><br><br>
      <label for="maths">Maths:</label>
      <input type="number" name="maths" required min="0" max="100"><br><br>
      <label for="science">Science:</label>
      <input type="number" name="science" required min="0" max="100"><br><br>
      <input type="submit" value="Add Student">
    </form>
  </body>
</html>
