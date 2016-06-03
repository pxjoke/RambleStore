'use strict';

/**
 * @ngdoc function
 * @name rambleApp.controller:LogoutCtrl
 * @description
 * # LogoutCtrl
 * Controller of the rambleApp
 */
angular.module('rambleApp')
  .controller('LogoutCtrl', function ($cookies, $rootScope, $location) {
    $cookies.remove('RmUser');
    $rootScope.rootUser = null;
    $location.url("/");
  });
