import Route from '@ember/routing/route';

export default Route.extend({
    actions: {
        makeTopics: function() {
            console.log("making")
            this.get('store').push({
                data: [
                    {
                        id: 1,
                        type: 'topic',
                        attributes: {
                            topicid: 1,
                            userid: "softwaredev123",
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
                            userid: "iwannalearn22",
                            contentid: 2,
                            topicline: "This is the second ever topic! Isn't that amazing?",
                            topicflagged: 0
                        }
                    }
                ]
            })
        },

        logOut: function() {
            this.get('store').unloadAll('userprofile')
            this.transitionTo('login')
        }

    }
});