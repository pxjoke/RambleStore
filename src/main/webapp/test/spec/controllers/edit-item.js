'use strict';

describe('Controller: EditItemCtrl', function () {

  // load the controller's module
  beforeEach(module('rambleApp'));

  var EditItemCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    EditItemCtrl = $controller('EditItemCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(EditItemCtrl.awesomeThings.length).toBe(3);
  });
});
