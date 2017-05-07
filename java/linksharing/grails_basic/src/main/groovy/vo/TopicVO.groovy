package vo

import com.ttn.linksharing.User
import enums.Visibility

/**
 * Created by priyanka on 7/5/17.
 */
class TopicVO {

    Long id
    String name
    Visibility visibility
    Integer count
    User createdBy

    String toString() {
        return "${name}"
    }
}
