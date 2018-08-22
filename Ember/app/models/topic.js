import DS from 'ember-data';

export default DS.Model.extend({
    topicid: DS.attr('number'),
    userid: DS.attr('string'),
    contentid: DS.attr('number'),
    topicline: DS.attr('string'),
    topicflagged: DS.attr('number')
});