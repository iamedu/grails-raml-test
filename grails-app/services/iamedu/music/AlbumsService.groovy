package iamedu.music

import grails.transaction.Transactional
import iamedu.raml.http.RamlResponse
import iamedu.raml.http.RamlQueryParam

@Transactional
class AlbumsService {

  RamlResponse post(@RamlQueryParam("access_token") String accessToken, Map data) {
    data.accessToken = accessToken
    RamlResponse.create().body(data)
  }
}
