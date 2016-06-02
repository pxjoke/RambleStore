'use strict';

/**
 * @ngdoc overview
 * @name rambleApp
 * @description
 * # rambleApp
 *
 * Main module of the application.
 */
angular
  .module('rambleApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ui-notification',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .when('/catalog', {
        templateUrl: 'views/catalog.html',
        controller: 'CatalogCtrl',
        controllerAs: 'catalog'
      })
      .when('/support', {
        templateUrl: 'views/support.html',
        controller: 'SupportCtrl',
        controllerAs: 'support'
      })
      .when('/items/:itemID', {
        templateUrl: 'views/item.html',
        controller: 'ItemCtrl',
        controllerAs: 'item'
      })
      .when('/users', {
        templateUrl: 'views/users.html',
        controller: 'UsersCtrl',
        controllerAs: 'users'
      })
      .when('/user', {
        templateUrl: 'views/user.html',
        controller: 'UserCtrl',
        controllerAs: 'user'
      })
      .when('/cart', {
        templateUrl: 'views/cart.html',
        controller: 'CartCtrl',
        controllerAs: 'cart'
      })
      .when('/create-item', {
        templateUrl: 'views/create-item.html',
        controller: 'CreateItemCtrl',
        controllerAs: 'createItem'
      })
      .when('/edit-item/:itemID', {
        templateUrl: 'views/edit-item.html',
        controller: 'EditItemCtrl',
        controllerAs: 'editItem'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
