import Route from '@ember/routing/route';
import RSVP from 'rsvp';

export default Route.extend({
    model(params) {
        return RSVP.hash({
            topic: this.get('store').peekRecord('userprofile', params.topicid),
            tpcresource: this.get('store').peekRecord('resource', this.topic.contentid),
            replies: this.get('store').findAll('reply', params.topicid),
            /**resources: (
                this.replies.forEach(function(resource) {
                
                })
            )*/
        })
    }
});