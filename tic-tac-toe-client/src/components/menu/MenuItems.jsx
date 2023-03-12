import ListGroup from 'react-bootstrap/ListGroup';
import Nav from 'react-bootstrap/Nav';
import {Link} from "react-router-dom";

const MenuItems = () => {
	return (
			<Nav className="flex-column">
				<ListGroup variant="flush">
					<ListGroup.Item>
						<Nav.Link><Link to='/game'>Game</Link></Nav.Link>
					</ListGroup.Item>
					<ListGroup.Item>
						<Nav.Link><Link to='/chat'>Chat</Link></Nav.Link>
					</ListGroup.Item>
					<ListGroup.Item>
						<Nav.Link href='/menu3'>Menu 3</Nav.Link>
					</ListGroup.Item>
					<ListGroup.Item>
						<Nav.Link href='/menu4'>Menu 4</Nav.Link>
					</ListGroup.Item>
					<ListGroup.Item>
						<Nav.Link href='/menu5'>Menu 5</Nav.Link>
					</ListGroup.Item>
				</ListGroup>
			</Nav>
	);
}

export default MenuItems;