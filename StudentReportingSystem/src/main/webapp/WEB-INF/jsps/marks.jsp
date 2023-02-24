<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Add Marks</title>
  </head>
  <body>
    <h1>Add Marks</h1>
    <form method="post" action="${pageContext.request.contextPath}/addMarks">
      <label for="name">Name:</label>
      <input type="text" name="name" required><br><br>
      <label for="semester">Semester:</label>
      <select name="semester" required>
        <option value="1">1st Semester</option>
        <option value="2">2nd Semester</option>
      </select><br><br>
      <label for="subject">Subject:</label>
      <select name="subject" required>
        <option value="english">English</option>
        <option value="maths">Maths</option>
        <option value="science">Science</option>
      </select><br><br>
      <label for="marks">Marks:</label>
      <input type="number" name="marks" required min="0" max="100"><br><br>
      <input type="submit" value="Add Marks">
    </form>
  </body>
</html>
