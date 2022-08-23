
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import BookRentalManager from "./components/listers/BookRentalCards"
import BookRentalDetail from "./components/listers/BookRentalDetail"

import BookManagementManager from "./components/listers/BookManagementCards"
import BookManagementDetail from "./components/listers/BookManagementDetail"

import PointManager from "./components/listers/PointCards"
import PointDetail from "./components/listers/PointDetail"


import ListView from "./components/ListView"
import ListViewDetail from "./components/ListViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/bookRentals',
                name: 'BookRentalManager',
                component: BookRentalManager
            },
            {
                path: '/bookRentals/:id',
                name: 'BookRentalDetail',
                component: BookRentalDetail
            },

            {
                path: '/bookManagements',
                name: 'BookManagementManager',
                component: BookManagementManager
            },
            {
                path: '/bookManagements/:id',
                name: 'BookManagementDetail',
                component: BookManagementDetail
            },

            {
                path: '/points',
                name: 'PointManager',
                component: PointManager
            },
            {
                path: '/points/:id',
                name: 'PointDetail',
                component: PointDetail
            },


            {
                path: '/lists',
                name: 'ListView',
                component: ListView
            },
            {
                path: '/lists/:id',
                name: 'ListViewDetail',
                component: ListViewDetail
            },


    ]
})
