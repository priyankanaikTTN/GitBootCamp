package com.ttn.linksharing

import co.ResourceSearchCO
import enums.Visibility
import vo.PostVO
import vo.RatingInfoVO
import vo.TopicVO

class ResourceController {

    def index() { }

    def show(Long id) {

         Resource resource = Resource.get(id)
         RatingInfoVO ratingInfoVO = resource.getRatingInfo()

        render ratingInfoVO
    }

    def delete(long id)
    {
        Resource resource = Resource.get(id)
        if (session['user'] && resource)
        {  if(resource.delete())
            {
               flash.message= "resource deleted"

            }
           else
            {
                flash.error = "could not delete resource"
            }
        }
        else
        {
            flash.error = "resource user is not set"
        }

    }


    def search(ResourceSearchCO resourceSearchCO) {


        if (resourceSearchCO.q) {


        }

    }
}
