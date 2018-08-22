import Route from '@ember/routing/route';

export default Route.extend({
    model() {
        return (this.get('store').peekRecord('userprofile', 1));
    },
    actions: {
        makeTopics: function() {
            this.get('store').push({
                data: [
                    {
                        id: 1,
                        type: 'topic',
                        attributes: {
                            topicid: 1,
                            userid: "meme",
                            contentid: 1,
                            topicline: "This is the first ever topic!",
                            topicflagged: 0
                        }
                    },
                    {
                        id: 2,
                        type: 'topic',
                        attributes: {
                            topicid: 2,
                            userid: "meme",
                            contentid: 2,
                            topicline: "This is the second ever topic! Isn't that amazing?",
                            topicflagged: 0
                        }
                    }
                ]
            })
        },
        getTopics: function() {
            return this.get('store').findAll('topic')
        }
    }
});