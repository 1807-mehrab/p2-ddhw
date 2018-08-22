import DS from 'ember-data';

export default DS.Model.extend({
    user: DS.attr('string'),
    userpass: DS.attr('string'),
    adminInt: DS.attr('number')
});