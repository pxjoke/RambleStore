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
      .otherwise({
        redirectTo: '/'
      });
  });
