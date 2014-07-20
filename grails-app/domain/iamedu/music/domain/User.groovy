package iamedu.music.domain

class User {
  def passwordService

  static hasMany = [permissions: String,
                    roles: Role]

  String username
  String password

  static constraints = {
    username unique: true
  }

  def beforeInsert() {
    encodePassword()
  }

  def beforeUpdate() {
    if(isDirty('password')) {
      encodePassword()
    }
  }

  private def encodePassword() {
    password = passwordService.encryptPassword(password)
  }
}
