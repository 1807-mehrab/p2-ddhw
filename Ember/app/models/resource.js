import DS from 'ember-data';

export default DS.Model.extend({
    contentid: DS.attr('number'),
    text: DS.attr('string'),
    image: DS.attr('string'),
    video: DS.attr('string'),
    document: DS.attr('string')
});