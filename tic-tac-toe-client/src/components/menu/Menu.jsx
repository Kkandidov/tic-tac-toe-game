import React, {useState} from 'react';
import Button from 'react-bootstrap/Button';
import Offcanvas from 'react-bootstrap/Offcanvas';
import MenuItems from "./MenuItems";

const Menu = () => {
	const [show, setShow] = useState(false);

	const onClose = () => setShow(false);
	const onShow = () => setShow(true);

	return (
			<>
				<Button variant="primary" onClick={onShow}>Menu</Button>
				<Offcanvas show={show} onHide={onClose}>
					<Offcanvas.Header closeButton>
						<Offcanvas.Title>MENU</Offcanvas.Title>
					</Offcanvas.Header>
					<Offcanvas.Body>
						<MenuItems/>
					</Offcanvas.Body>
				</Offcanvas>
			</>
	);
}

export default Menu;