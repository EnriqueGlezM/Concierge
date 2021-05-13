import React, {Component} from "react";
import "./App.css";
import {connect} from "react-redux";
import {
    userAnswer,
    submit,
    endSession,
    updateProfile,
    changeRestaurant,
    changeRoomServices,
    changeTransport,
    conditions,
    increase,
    decrease,
    addProduct,
    removeProduct,
    clearCart,
    initData,
} from "./redux/actions";

import Home from "./Views/Home/Home";
import Login from "./Views/Login/Login";
import Welcome from "./Views/Welcome/Welcome";
import Profile from "./Views/Profile/Profile";
import Transports from "./services/Transport/Transports";
import Restaurants from "./services/Restaurants/Restaurants";
import RoomServices from "./services/Room Service/RoomServices";
import ShowRestaurant from "./services/Restaurants/ShowRestaurant";
import ShowTransport from "./services/Transport/ShowTransport";

import {BrowserRouter as Router, Route} from "react-router-dom";
import Prices from "./Views/Prices";

import Store from "./ShoppingCart/pages/store/Store";
import Cart from "./ShoppingCart/pages/cart/Cart";
import Report from "./Views/Report/Report";
import ScrollToTop from "./ScrollToTop";
import CheckOut from "./Views/CheckOut/CheckOut";
import Shows from "./services/Shows/Shows";
import Tours from "./services/Touristic Tours/Tours";
import Reservation from "./services/Restaurants/Reservation";
import GoogleMaps from "./services/Restaurants/GoogleMaps";
import HotelReservation from "./Views/HotelReservation/HotelReservation";
import TourReservation from "./services/Touristic Tours/TourReservation";


class App extends Component {
    constructor(props) {
        super(props);
        this.timerlog = null;
        this.submit = this.submit.bind(this);
        this.download = this.download.bind(this);
        this.conditions = this.conditions.bind(this);
        this.filterProducts = this.filterProducts.bind(this);
        this.state = {
            products: this.props.products,
            shows: this.props.shows
        };
    }

    /* Esta funcion descarga el json de los clientes. Se llama a initClients
    *  para guardar en el estado el array de los clientes.
    *  initClients es la acción (ver actions.js)
    * */

    download() {
        let initJson = [];

        Promise.all([
            fetch("http://localhost:8080/Concierge01/rest/client").then(res => res.json()),
            fetch("http://localhost:8080/Concierge01/rest/shopping").then(res => res.json())
        ]).then(([clients, shopping]) => {
            initJson = [clients, shopping];
            this.props.dispatch(initData(initJson));
        })
    }

    submit() {
        this.props.dispatch(submit(this.props.clients));
        let alert = document.querySelector("#alert");
        alert.style.visibility = "visible";
        this.timerlog = setTimeout(() => (alert.style.visibility = "hidden"), 5000);
    }

    filterProducts(category, isShow) {
        if (isShow) {
            this.setState({
                shows: this.props.shows.filter(show => show.category === category)
            });
        } else {
            this.setState({
                products: this.props.products.filter(product => product.category === category)
            });
        }
    }

    componentWillUnmount() {
        clearTimeout(this.timerlog);
    }

    componentDidMount() {
        this.download();
    }

    conditions() {
        this.props.dispatch(conditions());
    }

    render() {
        return (
            <div>
                <Router>
                    <ScrollToTop/>
                    <Route
                        exact
                        path="/"
                        render={() => (
                            <Home
                                login={this.props.login}
                                update={(newData) => {
                                    this.props.dispatch(
                                        updateProfile(this.props.login.id, newData)
                                    );
                                }}
                                clients={this.props.clients}
                                client={this.props.clients[this.props.login.id - 1]}
                            />
                        )}
                    />

                    <Route
                        path="/welcome/"
                        render={() => (
                            <Welcome conditions={this.conditions} login={this.props.login}/>
                        )}
                    />

                    <Route
                        path="/login/"
                        render={(props) => (
                            <Login
                                {...props}
                                clients={this.props.clients}
                                login={this.props.login}
                                onUserAnswer={(
                                    dni = this.props.login.dniAnswer,
                                    room = this.props.login.roomAnswer
                                ) => {
                                    this.props.dispatch(userAnswer(dni, room));
                                }}
                                submitFunction={this.submit}
                            />
                        )}
                    />

                    <Route
                        path="/profile/"
                        render={(props) => (
                            <Profile
                                {...props}
                                conditions={this.conditions}
                                client={this.props.clients[this.props.login.id - 1]}
                                login={this.props.login}
                                update={(newData) => {
                                    this.props.dispatch(
                                        updateProfile(this.props.login.id, newData)
                                    );
                                }}
                                endSession={() => {
                                    this.props.dispatch(endSession());
                                }}
                            />
                        )}
                    />

                    <Route
                        exact
                        path="/services/transport/"
                        render={(props) => (
                            <Transports
                                {...props}
                                client={this.props.clients[this.props.login.id - 1]}
                                login={this.props.login}
                                transports={this.props.services.transports}
                                onChangeTransport={(answer) => {
                                    this.props.dispatch(changeTransport(answer));
                                }}
                            />
                        )}
                    />

                    <Route
                        path="/services/transport/show_transport/"
                        render={(props) => (
                            <ShowTransport
                                {...props}
                                login={this.props.login}
                                client={this.props.clients[this.props.login.id - 1]}
                                update={(newData) => {
                                    this.props.dispatch(
                                        updateProfile(this.props.login.id, newData)
                                    );
                                }}
                                currentTransport={
                                    this.props.services.transports[this.props.currentService]
                                }
                            />
                        )}
                    />

                    <Route
                        exact
                        path="/services/restaurants/"
                        render={(props) => (
                            <Restaurants
                                {...props}
                                restaurants={this.props.services.restaurants}
                                client={this.props.clients[this.props.login.id - 1]}
                                login={this.props.login}
                                onChangeRestaurant={(answer) => {
                                    this.props.dispatch(changeRestaurant(answer));
                                }}
                            />
                        )}
                    />

                    <Route
                        exact
                        path="/services/restaurants/reservation"
                        render={(props) => (
                            <Reservation
                                {...props}
                                login={this.props.login}
                                client={this.props.clients[this.props.login.id - 1]}

                            />
                        )}
                    />

                    <Route
                        exact path="/services/restaurants/reservation/map"
                        render={() => (
                            <GoogleMaps/>
                        )}
                    />

                    <Route
                        path="/services/restaurants/show_restaurant/"
                        render={(props) => (
                            <ShowRestaurant
                                {...props}
                                currentRestaurant={
                                    this.props.services.restaurants[this.props.currentService]
                                }
                                client={this.props.clients[this.props.login.id - 1]}
                                update={(newData) => {
                                    this.props.dispatch(
                                        updateProfile(this.props.login.id, newData)
                                    );
                                }}
                                login={this.props.login}
                            />
                        )}
                    />

                    <Route
                        path="/services/room_services/"
                        render={(props) => (
                            <RoomServices
                                {...props}
                                client={this.props.clients[this.props.login.id - 1]}
                                login={this.props.login}
                                roomServices={this.props.services.roomServices}
                                onChangeRoomServices={(answer) => {
                                    this.props.dispatch(changeRoomServices(answer));
                                }}
                                onSelectProducts={(category) => this.filterProducts(category, false)}
                            />
                        )}
                    />

                    <Route
                        path="/services/shows/"
                        render={(props) => (
                            <Shows
                                {...props}
                                client={this.props.clients[this.props.login.id - 1]}
                                login={this.props.login}
                                shows={this.props.services.showsData}
                                onChangeRoomServices={(answer) => {
                                    this.props.dispatch(changeRoomServices(answer));
                                }}
                                onSelectProducts={(category) => this.filterProducts(category, true)}
                            />
                        )}
                    />

                    <Route
                        exact path="/services/tours/"
                        render={(props) => (
                            <Tours
                                {...props}
                                client={this.props.clients[this.props.login.id - 1]}
                                login={this.props.login}
                                tours={this.props.services.tours}
                                onChangeRoomServices={(answer) => {
                                    this.props.dispatch(changeRoomServices(answer));
                                }}
                                onSelectProducts={(category) => this.filterProducts(category)}
                            />
                        )}
                    />
                    <Route
                        exact
                        path="/services/tours/tourReservation"
                        render={(props) => (
                            <TourReservation
                                {...props}
                                login={this.props.login}
                                client={this.props.clients[this.props.login.id - 1]}

                            />
                        )}
                    />

                    <Route
                        path="/prices/"
                        render={(props) => (
                            <Prices
                                {...props}
                                login={this.props.login}
                                client={this.props.clients[this.props.login.id - 1]}
                                update={(newData) => {
                                    this.props.dispatch(
                                        updateProfile(this.props.login.id, newData)
                                    );
                                }}
                            />
                        )}
                    />

                    <Route
                        exact path="/shopping/"
                        render={() => (
                            <Store
                                client={this.props.clients[this.props.login.id - 1]}
                                login={this.props.login}
                                products={this.state.products}
                                cartItems={this.props.cartItems}
                                isShow={false}
                                increase={(product) => {
                                    this.props.dispatch(increase(product));
                                }}
                                addProduct={(product) => {
                                    this.props.dispatch(addProduct(product));
                                }}
                            />
                        )}
                    />

                    <Route
                        path="/shopping/cart"
                        render={() => (
                            <Cart
                                client={this.props.clients[this.props.login.id - 1]}
                                products={this.props.products}
                                cartItems={this.props.cartItems}
                                clearCart={() => {
                                    this.props.dispatch(clearCart());
                                }}
                                increase={(product) => {
                                    this.props.dispatch(increase(product));
                                }}
                                decrease={(product) => {
                                    this.props.dispatch(decrease(product));
                                }}
                                removeProduct={(product) => {
                                    this.props.dispatch(removeProduct(product));
                                }}
                                clients={this.props.clients}
                                login={this.props.login}
                                update={(changeOne, isPoints) => {
                                    this.props.dispatch(
                                        updateProfile(this.props.login.id, [], changeOne, isPoints)
                                    );
                                }}
                            />
                        )}
                    />

                    <Route
                        exact path="/shows/tickets"
                        render={() => (
                            <Store
                                client={this.props.clients[this.props.login.id - 1]}
                                login={this.props.login}
                                products={this.state.shows}
                                isShow={true}
                                cartItems={this.props.cartItems}
                                increase={(product) => {
                                    this.props.dispatch(increase(product));
                                }}
                                addProduct={(product) => {
                                    this.props.dispatch(addProduct(product));
                                }}
                            />
                        )}
                    />

                    <Route path="/shopping/report"
                           render={() => (
                               <Report
                                   client={this.props.clients[this.props.login.id - 1]}
                                   login={this.props.login}
                               />
                           )}
                    />

                    <Route
                        path="/checkOut/"
                        render={(props) => (
                            <CheckOut
                                {...props}
                                conditions={this.conditions}
                                client={this.props.clients[this.props.login.id - 1]}
                                login={this.props.login}
                                update={(newData) => {
                                    this.props.dispatch(
                                        updateProfile(this.props.login.id, newData)
                                    );
                                }}
                                endSession={() => {
                                    this.props.dispatch(endSession());
                                }}
                            />
                        )}
                    />


                    <Route
                        path="/HotelReservation/"
                        render={(props) => (
                            <HotelReservation
                                {...props}
                                conditions={this.conditions}
                                client={this.props.clients[this.props.login.id - 1]}
                                login={this.props.login}
                                update={(newData) => {
                                    this.props.dispatch(
                                        updateProfile(this.props.login.id, newData)
                                    );
                                }}
                                endSession={() => {
                                    this.props.dispatch(endSession());
                                }}
                            />
                        )}
                    />

                </Router>
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {
        ...state,
    };
}

export default connect(mapStateToProps)(App);
