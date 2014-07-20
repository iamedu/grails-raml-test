package iamedu.music

import grails.transaction.Transactional
import iamedu.raml.http.RamlResponse

@Transactional
class AlbumsService {

  RamlResponse post(Map data) {
    RamlResponse.create().body(data)
  }
}
