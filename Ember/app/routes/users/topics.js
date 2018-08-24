import Route from '@ember/routing/route';

export default Route.extend({
    model() {
        console.log("gettin topics yo")
        return this.get('store').findAll('topic')
    }
});