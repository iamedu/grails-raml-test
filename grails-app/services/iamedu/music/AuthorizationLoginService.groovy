package iamedu.music

import grails.transaction.Transactional
import org.apache.shiro.SecurityUtils
import org.apache.shiro.authc.UsernamePasswordToken

import org.apache.shiro.authc.UnknownAccountException
import org.apache.shiro.authc.IncorrectCredentialsException

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

  def handleInvalidUsername(UnknownAccountException ex) {
    RamlResponse.create().statusCode(403).body([
      error: 'invalidUsername',
      message: ex.message
    ])
  }

  def handleInvalidPassword(IncorrectCredentialsException ex) {
    RamlResponse.create().statusCode(403).body([
      error: 'invalidPassword',
      message: ex.message
    ])
  }

}
