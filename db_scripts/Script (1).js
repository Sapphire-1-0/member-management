use member-management;

db.createUser({
  user: "membermanagementadmin",
  pwd: "password",
  roles: [
    { role: "readWrite", db: "member-management" }
  ]
})