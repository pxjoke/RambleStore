'use strict';

/**
 * @ngdoc function
 * @name rambleApp.controller:ItemCtrl
 * @description
 * # ItemCtrl
 * Controller of the rambleApp
 */
angular.module('rambleApp')
  .controller('ItemCtrl', function (Items, $routeParams) {
    var that = this;
    that.itemID = $routeParams.itemID;
    
    
  });
