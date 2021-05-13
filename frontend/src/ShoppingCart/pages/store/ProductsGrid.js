import React from 'react';
import ProductItem from './ProductItem';
import styles from './ProductsGrid.module.css';

export default class ProductsGrid extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            showPoints: false
        };
    }

    render() {

        return (
            <div>
                <div className="row">
                    <div className="col-sm-8">
                        <div className="py-3">
                            {this.props.products.length} {this.props.isShow ? 'Shows' : 'Products'}
                        </div>
                    </div>

                    <div className="custom-control custom-switch"
                         style={{justifyContent: 'flex-end', alignItems: 'center', display: 'flex', flex: 1, paddingRight: '15px'}}>
                        <input type="checkbox" className="custom-control-input" id="customSwitch1"
                               onClick={ () => {
                                   this.setState( {showPoints: !this.state.showPoints})
                               }}
                        />
                        <label className="custom-control-label" htmlFor="customSwitch1">Show in Hotel Points</label>
                    </div>

                </div>
                <div className={this.props.isShow ? styles.show_grid : styles.p_grid}>

                    {
                        this.props.products.map(product => {

                            let isInCart = this.props.cartItems.some(item => item.id === product.id)

                            return <ProductItem
                                showPoints={this.state.showPoints}
                                key={product.id}
                                isShow={this.props.isShow}
                                product={product}
                                isInCart={isInCart}
                                increase={this.props.increase}
                                addProduct={this.props.addProduct}
                            />
                        })
                    }

                </div>
            </div>
        );
    }
}