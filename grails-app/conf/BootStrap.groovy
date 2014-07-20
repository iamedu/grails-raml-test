import iamedu.music.domain.*

class BootStrap {

  def init = { servletContext ->
    def role = new Role(name: "Admin")
    role.addToPermissions('*:*')
    role.save(failOnError: true)
    def user = new User(username: 'username', password: 'password')
    user.addToPermissions('hola:adios')
    user.addToRoles(role)
    user.save(failOnError: true)
  }

  def destroy = {
  }
}
