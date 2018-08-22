import Route from '@ember/routing/route';

export default Route.extend({
    actions: {
        signUp: function(uName, uPass) {
            console.log(uName)
            console.log(uPass)
        }
    }
});