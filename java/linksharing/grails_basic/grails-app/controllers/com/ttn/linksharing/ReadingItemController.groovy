package com.ttn.linksharing

class ReadingItemController {

    def index() { }

    def changeIsRead(Long id, Boolean isRead)
    {

        User user = session['user']
        Resource resource = Resource?.get(id)
        if (user && resource) {

            ReadingItem readingItem = ReadingItem.findByUserAndResource(user,resource)

            if ( readingItem)
            {
                readingItem.isRead=isRead
                Boolean bool =User.executeUpdate("update User set readingItem=:readingItem where resource=:resource",
                        [readingItem:readingItem,resource:resource])

                if (bool)
                 flash.message= "change.is.read.successful"
                else
                    flash.message="change.is.read.not.successful"

            }
            else
            {
                 flash.message="readItem.does.not.exist"
            }
        }

        else
        {
            flash.message="user.not.set"  }


          render flash.message


    }

    def toggleIsRead(Long id) {
        User user = session.user
        Resource resource = Resource.get(id)
        if (user && resource) {
            ReadingItem readingItem = ReadingItem.findByResourceAndUser(resource, user)
            if (readingItem) {
                readingItem.isRead = !readingItem.isRead
            } else {
                readingItem = new ReadingItem(resource: resource, user: user, isRead: true)
            }
            if (readingItem.save(flush:true)) {
                flash.message = "Status updated"
            } else {
                flash.error = readingItem.errors.allErrors.collect { message(error: it) }.join('<br/>')
            }
            redirect(controller: 'topic', action: 'index', id: resource.topic.id)
        } else {
            render(view: '')
        }
    }

}
