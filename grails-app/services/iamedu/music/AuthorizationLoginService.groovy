package iamedu.music

import grails.transaction.Transactional
import org.apache.shiro.SecurityUtils
import org.apache.shiro.authc.UsernamePasswordToken

import iamedu.raml.http.RamlResponse

@Transactional
class AuthorizationLoginService {

  def post(Map params) {
    def subject = SecurityUtils.subject

    def token = new UsernamePasswordToken(params.username, params.password)
    subject.login(token)
    RamlResponse.create().body([
      token: subject.session.id
    ])
  }

}
