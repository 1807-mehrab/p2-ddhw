import Route from '@ember/routing/route';

export default Route.extend({
    actions: {
        logIn: function(uName, uPass) {
            console.log(uName)
            console.log(uPass)
            var self = this
            this.get('store').unloadAll('userprofile')
            this.get('store').push({
                data: {
                    id: 1,
                    type: 'userprofile',
                    attributes: {
                        user: uName,
                        userpass: uPass,
                        adminInt: 0
                    }
                }
            }).save().then(
                (function() {
                    self.transitionTo('users');
                }),
                (function() {
                    self.get('store').unloadAll('userposter');
                    self.refresh;
                })
            )
            
            //this.transitionTo('users.profile')
        }
    }
});