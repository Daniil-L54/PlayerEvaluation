protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

    String name = req.getParameter("name");
    String fullName = req.getParameter("fullName");
    String ageStr = req.getParameter("age");
    String indexIdStr = req.getParameter("indexId");

    if (name.isEmpty() || fullName.isEmpty() || ageStr.isEmpty()) {
        req.setAttribute("error", "All fields are required");
        req.getRequestDispatcher("player-form.jsp").forward(req, resp);
        return;
    }

    int age;
    try {
        age = Integer.parseInt(ageStr);
    } catch (Exception e) {
        req.setAttribute("error", "Age must be number");
        req.getRequestDispatcher("player-form.jsp").forward(req, resp);
        return;
    }

    if (age < 10 || age > 60) {
        req.setAttribute("error", "Age must be 10-60");
        req.getRequestDispatcher("player-form.jsp").forward(req, resp);
        return;
    }

    Player p = new Player();
    p.setName(name);
    p.setFullName(fullName);
    p.setAge(age);
    p.setIndexId(Integer.parseInt(indexIdStr));

    new PlayerDAO().insert(p);
    resp.sendRedirect("PlayerServlet?action=list");
}
