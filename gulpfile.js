'use strict';

var gulp = require('gulp')
    ,sass = require('gulp-sass');

gulp.task('sass', function(){
  gulp.src('src/main/webapp/assets/css/*.scss')
      .pipe(sass())
      .pipe(gulp.dest('src/main/webapp/assets/css'));
});
