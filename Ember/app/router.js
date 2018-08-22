import EmberRouter from '@ember/routing/router';
import config from './config/environment';

const Router = EmberRouter.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('users', {path: '/app'}, function() {
    this.route('topics');
    this.route('profile');
  });
  this.route('login', {path: '/'});
});

export default Router;
