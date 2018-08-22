import DS from 'ember-data';

export default DS.Model.extend({
    replyid: DS.attr('number'),
    topicid: DS.attr('number'),
    userid: DS.attr('string'),
    contentid: DS.attr('number'),
    replyflagged: DS.attr('number')
});