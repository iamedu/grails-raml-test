package iamedu.music

import grails.transaction.Transactional
import iamedu.raml.http.RamlResponse
import iamedu.raml.http.RamlParam

@Transactional
class AlbumService {

  RamlResponse get(@RamlParam(value="albumId") String albumId) {
    RamlResponse.create().body([id:albumId])
  }
}
